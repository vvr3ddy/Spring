package example04.com.cg.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import example04.com.cg.entity.TextEditor;

public class Client {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("example04.com.cg");
		ctx.refresh();
		TextEditor te = (TextEditor) ctx.getBean("textEditor");
		
		te.spellCheck();
	}
}
