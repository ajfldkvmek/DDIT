package kr.or.ddit.poi;

import java.util.Iterator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.or.ddit.poi.vo.ExcelData;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/poi")
public class ExcelController {
	
	
	@RequestMapping(value="/uploadTest.do", method = RequestMethod.GET)
	public String uploadTest() {
		return "poi/uploadTest";
	}
	
	@ResponseBody
	@RequestMapping(value="/uploadExcel.do", method = RequestMethod.POST)
	public ResponseEntity<ExcelData> excelData(@RequestParam("file") MultipartFile file){
		
		log.info("excelData() 와따리~~~");
	
		/*
		 * MultipartFile file = null;
		 * 
		 * Iterator<String> it = request.getFileNames(); System.out.println("it>>>>> " +
		 * it); if(it.hasNext()) file=request.getFile(it.next());
		 * System.out.println("fileName>>>>> " + file);
		 */
		
		
//		return new ResponseEntity<ExcelData>(data, HttpStatus.OK);
		return null;
	}

}
