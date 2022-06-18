public class CarInfo {
	private int queueNumber;
	private String plateNumber;
	private State state;

	public CarInfo(int queueNumber, String plateNumber){
		this.queueNumber = queueNumber;
		this.plateNumber = plateNumber;
		this.state = new State();
	}
	//getter setter
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getPlateNumeber(){
		return this.plateNumber;
	}

	public void changeState(){
		this.state.changeState();
	}

	public String getStateStr(){
		return this.state.toString();
	}
	public int getState(){
		return this.state.getState();
	}
	//method that make int to string
	public String toString(){
		return queueNumber + "\t" + plateNumber + "\t" + state;
	}
}