package automark.compiler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

/**
 * class字节文件对象
 * @author fyu
 *
 */
public class ByteFileObject extends SimpleJavaFileObject {  
	  
    protected final ByteArrayOutputStream bos = new ByteArrayOutputStream();  
  
    public ByteFileObject(String name, JavaFileObject.Kind kind) {  
        super(URI.create("string:///" + name.replace('.', '/') + kind.extension), kind);  
    }  
  
    public byte[] getBytes() {  
        return this.bos.toByteArray();  
    }  
  
    public OutputStream openOutputStream() throws IOException {  
        return this.bos;  
    }  
} 
