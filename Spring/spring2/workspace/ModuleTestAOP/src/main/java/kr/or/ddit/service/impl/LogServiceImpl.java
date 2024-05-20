package kr.or.ddit.service.impl;

import org.springframework.stereotype.Service;

import kr.or.ddit.service.ILogService;

@Service
public class LogServiceImpl implements ILogService {

	@Override
	public String test() {
		return "logging test";
	}

	
	@Override
	public String appendString(String[] strArr) {
		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		
		for(String s : strArr)
			sb.append(s);
		
		return sb.toString();
	}
	
	

}
