package Mode;

public abstract class Bridge {
public Source source;
public void method(){
//	source.method1();
//	source.method2();
}
public Source get(){
	return source;
}
public void set(Source source){
	this.source=source;
}
}
