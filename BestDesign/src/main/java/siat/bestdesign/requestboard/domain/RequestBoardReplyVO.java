package siat.bestdesign.requestboard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBoardReplyVO {
	private int auctionNum;
	private int requestNum;
	private String userId;
	private int auctionPrice;
	private String auctionDate;
	private int auctionState;
	private String auctionComment;
}
