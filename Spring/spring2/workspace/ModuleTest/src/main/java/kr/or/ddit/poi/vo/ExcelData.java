package kr.or.ddit.poi.vo;

import java.util.HashMap;
import java.util.List;

import lombok.Data;

@Data
public class ExcelData {

	List<String> colList;
	List<HashMap<String, String>> dataMap;
}
