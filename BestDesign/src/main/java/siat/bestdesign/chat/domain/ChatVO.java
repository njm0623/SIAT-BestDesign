package siat.bestdesign.chat.domain;

public class ChatVO {
	
	private int chatId;
	private String chatFromId;
	private String chatToId;
	private String chatContent;
	private String chatDate;
	private int ChatRead;
	
	public ChatVO() {}
	
	public ChatVO(int chatId, String chatFromId, String chatToId, String chatContent, String chatDate, int chatRead) {
		super();
		this.chatId = chatId;
		this.chatFromId = chatFromId;
		this.chatToId = chatToId;
		this.chatContent = chatContent;
		this.chatDate = chatDate;
		ChatRead = chatRead;
	}
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public String getChatFromId() {
		return chatFromId;
	}
	public void setChatFromId(String chatFromId) {
		this.chatFromId = chatFromId;
	}
	public String getChatToId() {
		return chatToId;
	}
	public void setChatToId(String chatToId) {
		this.chatToId = chatToId;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public String getChatDate() {
		return chatDate;
	}
	public void setChatDate(String chatDate) {
		this.chatDate = chatDate;
	}
	public int getChatRead() {
		return ChatRead;
	}
	public void setChatRead(int chatRead) {
		ChatRead = chatRead;
	}

}
