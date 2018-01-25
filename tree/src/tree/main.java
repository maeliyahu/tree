package tree;
import java.io.Console;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tree firstTree=new tree();
		boolean flag=true;
		Scanner in = new Scanner(System.in);
		while(flag) {
			System.out.println("Please enter value");

			int num = in.nextInt();
			if(num==0) {
				System.out.println(firstTree.inOrder(firstTree.root));
				System.out.println(firstTree.postOrder(firstTree.root));
				System.out.println(firstTree.preOrder(firstTree.root));
				flag=false;
			}
			firstTree.insertNode(num);

		}
		in.close();
	}

}
