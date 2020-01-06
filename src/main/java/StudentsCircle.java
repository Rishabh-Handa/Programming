import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsCircle {


    public static int president(int n, int k){
	List<Integer> students = new ArrayList<>();


	for(int i=1; i<=n; i++){
	    students.add(i);
	}

	int index = 0;
	while(students.size() > 1){
	    index += k-1;

	    if(index>=students.size()){
	        index = index - students.size();
	    }

	    students.remove(index);

	}

	return students.get(0);


    }

    public static void main(String[] args) {
	System.out.println(president(4,2));
    }
}
