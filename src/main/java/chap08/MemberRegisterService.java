package chap08;

import java.time.LocalDateTime;

public class MemberRegisterService
{
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao)
	{
		this.memberDao = memberDao;
	}
	
	public Long regist(RegisterRequest req)
	{
		Member member = memberDao.selectByEmail(req.getEmail());
		if (null != member)
			throw new RuntimeException(req.getEmail());
		member = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDao.insert(member);
		return member.getId();
		
	}
}
