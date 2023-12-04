package chap08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException
	{
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.println("명령어를 입력하세요: ");
			String command = reader.readLine();
			
			if (command.equalsIgnoreCase("exit"))
			{
				System.out.println("종료합니다.");
				break;
			}
			
			if (command.startsWith("new "))
			{
				processNewCommand(command.split("[ ]+"));
				continue;
			}
			else if (command.startsWith("change "))
			{
				processChangeCommand(command.split("[ ]+"));
				continue;
			}
			else if (command.equals("list"))
			{
				processListCommand();
				continue;
			}
			else
			{
				printHelp();
			}
		}
	}
	
	private static void processNewCommand(String[] args)
	{
		if (5 != args.length)
		{
			printHelp();
			return;
		}
		
		MemberRegisterService registerService = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]);
		
		if (!req.isPasswordEqualToConfirmPassword())
		{
			System.out.println("암호와 확인이 일치하지 않습니다.\n");
			return;
		}
		
		try {
			registerService.regist(req);
			System.out.println("등록했습니다.");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	private static void processChangeCommand(String[] args)
	{
		if (4 != args.length)
		{
			printHelp();
			return;
		}
		
		ChangePasswordService changePasswordService = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			changePasswordService.changePassword(args[1], args[2], args[3]);
			System.out.println("암호를 변경했습니다.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void processListCommand()
	{
		MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	}
	
	private static void printHelp()
	{
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법:");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재암호 변경암호");
		System.out.println();
	}
}
