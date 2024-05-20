package vo;

import lombok.Data;

@Data
public class RoomReserve {
	private int no;
	private String mem_id;
	private String seat_no;
	private String resv_time;
	private String resv_no;
	private String out_time;
}
