package Mode;

public class Factory {
public static void main(String[] args){
	MsgFactory factory=new MsgFactory();
	Sender sender=factory.produce("mail");
	sender.send();
	
	Sender sender1=factory.produceSms();
	sender1.send();
	
	Sender sender2=MsgFactory.producesms();
	sender2.send();
	
	//抽象工厂模式
	provider pro=new MailSend();
	Sender sender3=pro.produce();
	sender3.send();
}
}
class MsgFactory{
	//工厂模式
	public Sender produce(String type){
		if("mail".equals(type)){
			return new Mail();
		}else if("sms".equals(type)){
			return new Sms();
		}else{
			System.out.print("type error");
			return null;
		}
	}
	//多工厂模式
	public Sender produceMail(){
		return new Mail();
	}
	public Sender produceSms(){
		return new Sms();
	}
	
	//静态工厂模式
	public static Sender producemail(){
		return new Mail();
	}
	public static Sender producesms(){
		return new Sms();
	}
}
class MailSend implements provider{

	public Sender produce() {
		// TODO Auto-generated method stub
		return new Mail();
	}
	
}
class SmsSend implements provider{

	public Sender produce() {
		// TODO Auto-generated method stub
		return new Sms();
	}
	
}