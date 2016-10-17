package cn.saymagic.weixin.server.handler;


import cn.saymagic.weixin.server.bean.MsgRequest;

public class EventHandler extends BaseHandler {
	@Override
	public String doHandleMsg(MsgRequest msgRequest) {
		if(!"event".equals(msgRequest.getMsgType())) {
            return null;
        } else
			if("subscribe".equals(msgRequest.getEvent())){
				return getResponseStringByContent("欢迎您来到树山之家！目前只有一个智能机器人供玩耍，后续有时间弄点好玩的。哈哈", msgRequest);
			}else if("CLICK".equals(msgRequest.getEvent())){
				String eventKey = msgRequest.getEventKey();
				String content = "";
				content = "Click Menu"+msgRequest.getEventKey();
				return getResponseStringByContent(content, msgRequest);
			}
			else{
				return getResponseStringByContent("暂时无法处您的请求，请稍后再试。", msgRequest);
			}

	}
}
