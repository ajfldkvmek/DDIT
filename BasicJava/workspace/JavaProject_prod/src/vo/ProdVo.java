package vo;

import java.math.BigDecimal;

public class ProdVo {

	private String prod_name;
	private BigDecimal prod_cost;
	private String prod_color;
	private String prod_outline;
	private String id;
	private String prod_lgu;
	
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	
	public BigDecimal getProd_cost() {
		return prod_cost;
	}
	public void setProd_cost(BigDecimal prod_cost) {
		this.prod_cost = prod_cost;
	}
	
	public String getProd_color() {
		return prod_color;
	}
	public void setProd_color(String prod_color) {
		this.prod_color = prod_color;
	}
	
	public String getProd_outline() {
		return prod_outline;
	}
	public void setProd_outline(String prod_outline) {
		this.prod_outline = prod_outline;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getProd_lgu() {
		return prod_lgu;
	}
	public void setProd_lgu(String prod_lgu) {
		this.prod_lgu = prod_lgu;
	}
	
		
}
