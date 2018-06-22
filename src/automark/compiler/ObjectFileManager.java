package automark.compiler;

import java.io.IOException;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;

/**
 * 从内存中加载源文件
 * @author fyu
 *
 */
@SuppressWarnings("rawtypes")  
public class ObjectFileManager extends ForwardingJavaFileManager {  
    private ByteFileObject currObject;  
  
    @SuppressWarnings("unchecked")  
    public ObjectFileManager(StandardJavaFileManager standardManager) {  
        super(standardManager);  
    }  
  
    public JavaFileObject getJavaFileForOutput(JavaFileManager.Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {  
        this.currObject = new ByteFileObject(className, kind);  
        return this.currObject;  
    }  
  
    /** 
     * 返回缓存的Object 
     *  
     * @return 
     */  
    public ByteFileObject getCachedObject() {  
        return this.currObject;  
    }  
}  