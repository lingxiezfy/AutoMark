package automark.compiler;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.apache.log4j.Logger;


public class DynamicEngine {
	private static Logger logger = Logger.getLogger(DynamicEngine.class);  
    private static DynamicEngine instance = new DynamicEngine();  
    private URLClassLoader parentClassLoader;  
    private Class clazz;
    private String classpath;  
  
    public static DynamicEngine getInstance() {  
        return instance;  
    }  
  
    private DynamicEngine() {  
        this.parentClassLoader = (URLClassLoader) getClass().getClassLoader();  
        buildClassPath();  
    }  
    
    public URLClassLoader getParentClassLoader() {
    	return this.parentClassLoader;
    }
    public Class<?> getCompilerClass() {
    	return this.clazz;
    }
    
    private void buildClassPath() {  
        StringBuilder sb = new StringBuilder();  
        for (URL url : this.parentClassLoader.getURLs()) {  
            String p = url.getFile();  
            sb.append(p);  
            sb.append(File.pathSeparator);  
        }  
        this.classpath = sb.toString();  
    }  
  
    /** 
     * 编译Java代码（用来检查代码正确性） 
     *  
     * @param className 
     * @param javaCode 
     * @return 编译通过则为null，不通过返回错误日志 
     */  
    @SuppressWarnings({ "rawtypes", "unchecked" })  
    public String javaCodeCompile(String className, String javaCode) {  
        long start = System.currentTimeMillis();  
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();  
        DiagnosticCollector diagListener = new DiagnosticCollector();  
        ObjectFileManager fileManager = new ObjectFileManager(compiler.getStandardFileManager(diagListener, null, null));  
        List<StringFileObject> compileUnits = new ArrayList<StringFileObject>(1);  
        compileUnits.add(new StringFileObject(className, javaCode));  
        List<String> options = new ArrayList<String>(4);  
        options.add("-encoding");  
        options.add("UTF-8");  
        options.add("-classpath");  
        options.add(this.classpath);  
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagListener, options, null, compileUnits);  
        boolean success = task.call().booleanValue();  
        if (success) {  
            long end = System.currentTimeMillis();  
            logger.info("编译成功，用时:" + (end - start) + "ms");  
        } else {  
            StringBuilder error = new StringBuilder();  
            for (Object diagnostic : diagListener.getDiagnostics()) {  
                compilePrint(javaCode, error, (Diagnostic) diagnostic);  
            }  
            logger.error("编译失败:\n" + error);  
            return error.toString();  
        }  
        return null;  
    }  
  
    /** 
     * 编译Java代码（用来生成可用java对象） 
     *  
     * @param className 
     * @param javaCode 
     * @return 编译通过返回相应对象，不通过则为null 
     */  
    @SuppressWarnings({ "rawtypes", "unchecked" })  
    public Object javaCodeToObject(String className, String javaCode) throws Exception {  
        Object result = null;  
        long start = System.currentTimeMillis();  
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();  
        DiagnosticCollector diagListener = new DiagnosticCollector();  
        ObjectFileManager fileManager = new ObjectFileManager(compiler.getStandardFileManager(diagListener, null, null));  
        List<StringFileObject> compileUnits = new ArrayList<StringFileObject>(1);  
        compileUnits.add(new StringFileObject(className, javaCode));  
        List<String> options = new ArrayList<String>(4);  
        options.add("-encoding");  
        options.add("UTF-8");  
        options.add("-classpath");  
        options.add(this.classpath);  
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagListener, options, null, compileUnits);  
        boolean success = task.call().booleanValue();  
        if (success) {  
            ByteFileObject fileObject = fileManager.getCachedObject();  
            DynamicClassLoader dynamicClassLoader = new DynamicClassLoader(this.parentClassLoader);  
            //获取编译产生的类
            clazz = dynamicClassLoader.loadClass(className, fileObject);  
            result = clazz.newInstance();  
            long end = System.currentTimeMillis();  
            logger.info("编译成功，用时:" + (end - start) + "ms");  
            dynamicClassLoader.close();
        } else {  
            StringBuilder error = new StringBuilder();  
            for (Object diagnostic : diagListener.getDiagnostics()) {  
                compilePrint(javaCode, error, (Diagnostic) diagnostic);  
            }  
            logger.error("编译失败:\n" + error);  
            return error.toString();  
        }  
  
        return result;  
    }  
  
    /** 
     * 构造编译错误日志 
     *  
     * @param javaCode 
     * @param error 
     * @param diagnostic 
     */  
    @SuppressWarnings("rawtypes")  
    private void compilePrint(String javaCode, StringBuilder error, Diagnostic diagnostic) {  
        error.append(diagnostic.getMessage(null));  
        error.append('\n');  
        error.append(getLine(javaCode, (int) diagnostic.getLineNumber()));  
        error.append('\n');  
        error.append(rjust("^", (int) diagnostic.getColumnNumber()));  
        error.append('\n');  
    }  
  
    /** 
     * 取源数据的指定行 
     *  
     * @param source 源数据 
     * @param line 行号 
     * @return 确定的行 
     */  
    public String getLine(String source, int line) {  
        char[] chars = source.toCharArray();  
        int count = 1;  
        int n = chars.length;  
        int j = 0;  
        for (int i = 0; i < n;) {  
            // 寻找行
            while (i < n && chars[i] != '\n' && chars[i] != '\r'  
                    && Character.getType(chars[i]) != Character.LINE_SEPARATOR) {  
                i++;  
            }  
            // 跳过行
            int eol = i;  
            if (i < n) {  
                if (chars[i] == '\r' && i + 1 < n && chars[i + 1] == '\n') {  
                    i += 2;  
                } else {  
                    i++;  
                }  
            }  
            if (count == line) {  
                return source.substring(j, eol);  
            } else {  
                count++;  
            }  
            j = i;  
        }  
        if (j < n) {  
            return source.substring(j, n);  
        }  
        return source;  
    }  
  
    /** 
     * 左对齐（右方用空格填充） 
     *  
     * @param src 
     * @param width 
     * @return 
     */  
    public String ljust(String src, int width) {  
        return expand(src, width, ' ', true);  
    }  
  
    /** 
     * 右对齐（左方用空格填充） 
     *  
     * @param src 
     * @param width 
     * @return 
     */  
    public String rjust(String src, int width) {  
        return expand(src, width, ' ', false);  
    }  
  
    private String expand(String src, int width, char fillchar, boolean postfix) {  
        String result = src;  
        if (result.length() < width) {  
            char[] temp = new char[width - result.length()];  
            for (int i = 0; i < temp.length; i++) {  
                temp[i] = fillchar;  
            }  
            if (postfix) {  
                result = result + new String(temp);  
            } else {  
                result = new String(temp) + result;  
            }  
        }  
        return result;  
    }  
}
