package automark.compiler;

import java.net.URL;
import java.net.URLClassLoader;
/**
 * 加载字节文件
 * @author fyu
 *
 */
public class DynamicClassLoader extends URLClassLoader {  
    public DynamicClassLoader(ClassLoader parent) {  
        super(new URL[0], parent);  
    }  
  
    public Class<?> findClassByClassName(String className) throws ClassNotFoundException {  
        return findClass(className);  
    }  
  
    public Class<?> loadClass(String className, ByteFileObject byteFileObject) {  
        byte[] classData = byteFileObject.getBytes();  
        return defineClass(className, classData, 0, classData.length);  
    }  
}  
