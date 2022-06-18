import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class WaitingLine{
	private int queueNumber; // last car info
	private int currentQueueNumber; // current waiting or processing car info
	private Hashtable<Integer, CarInfo> line;
	private String[]carList;

	public WaitingLine(){
		this.queueNumber = 1;
		this.currentQueueNumber = 1;
		line = new Hashtable<>();
	}

	public void addCar(String plateNumber){
		CarInfo car = new CarInfo(queueNumber, plateNumber);
		if(line.size() == 0){
			System.out.println(line);
			car.changeState();
		}
		line.put(queueNumber, car);
		this.queueNumber++;
	}
	//check the car name
//	public void checkCar(String[] carList) {
//		for(int i = 0; i<carList.length;i++) {
//			if (carList[i].equals(this.getPlateNumber())) {
//				System.out.println("车名重复，请再输一遍");
//			}else 
//			{
//				continue;
//			}
//		}
//	}

	public void changeState(int queueNumber){
		CarInfo carInfo = line.get(queueNumber);
		carInfo.changeState();
		if(carInfo.getState() == 1){
			currentQueueNumber++;
			line.remove(queueNumber);
		}
	}

	public void changePlateNumber(int queueNumber, String plateNumber){
		line.get(queueNumber).setPlateNumber(plateNumber);
	}
//error
	public String toString(){
		String str = "======= Queue =======\n";
		for(int i = 0; i < 10; i++){
			int key = currentQueueNumber + i;
			if(key > queueNumber - 1) break;
			str += line.get(key).toString() + "\n";
		}
		return str;
	}
	public Object[][] getData(){
		List<Integer> v = new ArrayList<Integer>(line.keySet());
		Collections.sort(v);
		Object[][] tableData=new Object[v.size()][3];
		int i = 0;
		for (Integer index : v) {
			tableData[i][0] = index;
			tableData[i][1] = line.get(index).getPlateNumeber();
			tableData[i][2] = line.get(index).getStateStr();
			i++;
		}
		return tableData;

	}
	public void delCar(){
		//判断，
		List<Integer> v = new ArrayList<Integer>(line.keySet());
		Collections.sort(v);
		if(v.size()>1){
			line.get(v.get(0)).changeState();
			line.get(v.get(1)).changeState();
			line.remove(v.get(0));
		}else if (v.size()>0) {
			line.get(v.get(0)).changeState();
			line.remove(v.get(0));
		}
//		line.get(v.get(0)).changeState();
//		line.get(v.get(1)).changeState();
//		line.remove(v.get(0));
	}
}