package chap08;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DbConfig.class)
public class AppConfig
{
	@Autowired
	public DataSource dataSource;
	
	@Bean
	public MemberDao memberDao()
	{
		return new MemberDao(dataSource);
	}
	
	@Bean
	public MemberPrinter memberPrinter()
	{
		return new MemberPrinter();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc()
	{
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc()
	{
		ChangePasswordService svc = new ChangePasswordService();
		svc.setMemberDao(memberDao());
		return svc;
	}
	
	@Bean
	public MemberListPrinter listPrinter()
	{
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
}
