/*"ues strict"//오류 줄이고자
function autoClosingAlert(selector, delay){
	let alert = $(selector).alert();
	alert.show();
	window.setTimeout(function(){
		alert.hide()
	}, delay);
}

$("#sub").click(function(){
	let fromID = <%=userID%>;
	let toID = <%=toID%>;
	let chatContent = $("#chatContent").val();
	alert(fromID + " " + toID + " " + chatContent);
	$.ajax({
		type:"post",
		url:"chatAjax.jsp",
		data:{
			fromID : formID,
			toID : toID,
			chatContent : chatContent
		},
		success:function(data){
			if(date == 0){
				autoClosingAlert("#dangerMessage", 2000);
			}
		}
	})
		$("#chatContent").val("");
})*/
/*
let nickname = $("#chatName")
let chatList = $(".chatting-list")
let chatInput = $("#chatContent")
let sendButton = $("#sub")
let displayContainer = $("#chatList")



chatInput.addEventListener("keypress", (event)=>{
	
    if(event.keyCode === 13){
        send();
        chatInput.value=null;
    }
})

sendButton.addEventListener("click", send)

function send(){
alert("hi");
    const param ={
        name:nickname.value,
        msg:chatInput.value
    }
    socket.emit("chatting",param)
}

socket.on("chatting", (data)=>{
    const { name, msg, time} = data;
    const item = new LiModel(name, msg, time);
    item.makeLi();
    displayContainer.scrollTo(0, displayContainer.scrollHeight)
})

function LiModel(name, msg, time){
    this.name = name;
    this.msg = msg;
    this.time = time;

    this.makeLi = ()=>{
        const li = document.createElement("li");
        li.classList.add(nickname.value === this.name? "sent":"received")
        const dom = `<span class="profile">
                        <span class="user">${this.name}</span>
                        <img class="image" src="https://placeimg.com/50/50/any" alt="any">
                    </span>
                    <span class="message">${this.msg}</span>
                    <span class="time">${this.time}</span>`;
        li.innerHTML = dom;
        chatList.appendChild(li);
    }
}*/