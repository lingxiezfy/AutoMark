package automark.compiler;

import java.net.URI;

import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

public class StringFileObject extends SimpleJavaFileObject {  
	  
    private String content;  
  
    public StringFileObject(String className, String content) {  
        super(URI.create("string:///" + className.replace('.', '/') +  
                JavaFileObject.Kind.SOURCE.extension), Kind.SOURCE);  
        this.content = content;  
    }  
  
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {  
        return this.content;  
    }  
}  