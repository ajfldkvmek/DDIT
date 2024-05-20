package kr.or.ddit.controller.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.vo.Board;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/test_me")
public class TestController_me {
	
	@Autowired
    private ServletContext servletContext;
	
	@GetMapping("/getAbsolutePath")
    public String getAbsolutePath() {
        String absolutePath = servletContext.getRealPath("/WEB-INF/data/file.txt");
        
        return "absolutePath"; 
    }
	
	private List<String> imageList;
		
	@PostConstruct
	public void init() {
		String[] imageFileName = {
			"audi01.png",
			"audi02.png",
			"audi03.png",
			"audi04.png",
			"bmw.png",
			"bmw01.jpg",
			"bmw02.jpg",
			"bmw03.jpg",
			"bmw04.jpg",
			"bmw05.jpg",
			"gif01.gif",
			"gif02.gif",
			"gif03.gif",
			"gif04.gif",
			"jeep01.jpg",
			"jeep02.jpg",
			"jeep03.jpg",
			"jeep04.jpg",
			"jeep05.jpg",
			"jeep06.jpg"
		};
		imageList = new ArrayList<String>();
		for(int i = 0; i < imageFileName.length; i++) {
			imageList.add(imageFileName[i]);
		}
	}
	
	@RequestMapping(value="/test01.do")
	public String test(Model model) {
		model.addAttribute("imageFileList", imageList);
		return "script/test01_me";
	}
	
	
	@RequestMapping(value="/{ext}", method = RequestMethod.PUT)
	public ResponseEntity<List<String>> modifyList(@PathVariable String ext) {
		
		List<String> newList = new ArrayList<String>();

		if(ext.equals("all")) {
			return new ResponseEntity<List<String>>(imageList, HttpStatus.OK);
		} else {
			for(int i = 0; i < imageList.size(); i++ ) {
				if(imageList.get(i).endsWith(ext)) {
					newList.add(imageList.get(i));
				}
			}
			return new ResponseEntity<List<String>>(newList, HttpStatus.OK);
		}
	}
	
	
	@RequestMapping(value="/downloadFile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadFile(@RequestParam("realFile") String realFile) {
			
		String file =  realFile;
		
		//System.out.println("일단 여기 온 ㅏ함 벌까");
		
		String absolutePath = servletContext.getRealPath("/resources/image/"+realFile);
		System.out.println(absolutePath);
		
		String fileName = "ddit_download_file.zip";
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		HttpHeaders headers = new HttpHeaders();
		try {
			in = new FileInputStream(absolutePath);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; filename=  \"" +
						new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			try {
				in.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		
		//System.out.println(entity);
		return entity;
	}
	
	//이게 아마 썸네일일듯
//	@ResponseBody
//	@RequestMapping(value="/goRestHome1101", method=RequestMethod.GET)
//	public ResponseEntity<byte[]> goRestHome1101(){
//		log.info("goRestHome1101() 실행... ");
//				
//		InputStream in = null;
//		ResponseEntity<byte[]> entity = null;
//		
//		HttpHeaders headers = new HttpHeaders();
//		
//		try {
//			in = new FileInputStream("D:/img0.jpg");
//			headers.setContentType(MediaType.IMAGE_JPEG);
//			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
//		} finally {
//			try {
//				in.close();
//			} catch(IOException ex){
//				ex.printStackTrace();
//			}
//		}
//		return entity;
//	}
//	
//	
	
	
	
}
