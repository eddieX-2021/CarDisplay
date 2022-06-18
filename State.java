public class State {
	private int state;//-1, 0, 1
	//default constructor
	public State(){
		this.state = -1;
	}
	//constructor
	public State(int state){
		this.state = state;
	}
	//getter
	public int getState(){
		return state;
	}

	public String toString(){
		switch (state){
			case -1: return "等待中";
			case 0: return "进行中";
			case 1: return "已完成";
			default: return "错误";
		}
	}

	public void changeState(){
		this.state = (state == 1)? 1 : state + 1;
	}
}