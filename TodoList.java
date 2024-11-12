import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TodoList {

    private Scanner scanner;
    private ArrayList<String> tasks;
    
    public TodoList(){
        scanner = new Scanner(System.in);
        tasks  = new ArrayList<>();
    }
    public void run(){
        boolean running = true;
        while(running){
        System.out.println("----------To do list--------------");
        System.out.println("1.Add a task");
        System.out.println("2.Remove a task");
        System.out.println("3.View all tasks");
        System.out.println("4.Quit");
        System.out.print("Enter your choice: ");
        try{
        int choice = scanner.nextByte();
        scanner.nextLine();
        switch (choice) {
            case 1:
                addTask();
                break;
            case 2:
                removeTask();
                break;
            case 3:
                showTasks();
                break;
            case 4:
                running = false;
                break;
            default:
                System.out.println("Number out of range.");
        }
    }catch(InputMismatchException e){
        System.out.println("Invalid input.");
        scanner.nextLine();
    }
    }

    }
    private void addTask(){
        System.out.print("Enter a task: ");
        String task = scanner.nextLine();
        if(task.trim().equals("")){
            System.out.println("Tasks can't be blank");
            addTask();
        }
        else{
        tasks.add(task);
        System.out.println("Task add successfully.");
        }
    }
    private void removeTask(){
        System.out.print("Enter task number: ");
        int taskNum = scanner.nextInt();
        if(taskNum > 0 && taskNum <= tasks.size()){
        tasks.remove(taskNum - 1);
        System.out.println("Task removed successfully.");
        }
        else{
            System.out.println("invalid input number cannot be > task.size() or <0");
        }
        
    }
    public void showTasks(){
        if(tasks.isEmpty())
            System.out.println("No tasks to display");
        else{
            for(int i = 1; i < tasks.size();i++){
                System.out.println(i + ". " + tasks.get(i - 1));
            }
        }
            
    }
    public class Main{
        public static void main(String[] args) {
            TodoList task = new TodoList();
            task.run();
        }
    }

}

