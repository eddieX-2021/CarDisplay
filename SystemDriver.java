//import java.util.Scanner;
//
//public class SystemDriver {
//	public static void main(String[] args){
//		WaitingLine queue = new WaitingLine();
//
//		while (true) {
//			Scanner input = new Scanner(System.in);
//			System.out.print("按一添加车辆信息，按二修改车辆信息:");
//			int option = input.nextInt();
//			if (option == 1) {
//				System.out.print("请输入车牌号:");
//				String plateNumber = input.next();
//				queue.addCar(plateNumber);
//				System.out.println(queue);
//			}
//			else if (option == 2) {
//				System.out.print("按一修改车名，按二修改状态，按三修改全部:");
//				option = input.nextInt();
//				System.out.print("请输入序号:");
//				int key = input.nextInt();
//				if(option == 1) {
//					System.out.print("请输入新的车牌号:");
//					String plateNumber = input.next();
//					queue.changePlateNumber(key, plateNumber);
//					System.out.println(queue);
//				} else if (option == 2) {
//					queue.changeState(key);
//					System.out.print(queue);
//				}
//			}else {
//				System.out.println("输入错误，请重新输入:");
//				option = input.nextInt();
//			}
//		}
//	}
//}