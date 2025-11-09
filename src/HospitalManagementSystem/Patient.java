package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient
{

    private Connection connection;
    private Scanner scanner;

    public Patient(Connection connection, Scanner scanner)
    {
            this.connection = connection;
            this.scanner = scanner;

    }

    public void addPatient()
    {
        System.out.print("Enter patient name:");
        String name = scanner.next();
        System.out.print("Enter patient age:");
        int age = scanner.nextInt();
        System.out.print("Enter patient Gender:");
        String gender = scanner.next();

        try
            {
                String query = "INSERT INTO patients(name,age,gender) VALUES(?,?,?)";
                PreparedStatement prepareStatement = connection.prepareStatement(query);
                prepareStatement.setString(1,name);
                prepareStatement.setInt(2,age);
                prepareStatement.setString(3,gender);
                int affectRows = prepareStatement.executeUpdate();
                if (affectRows>0)
                {
                    System.out.println("Patient has been added");
                }
                else
                {
                    System.out.println("Patient has NOT been added");
                }
             }
        catch (SQLException e)
            {
                e.printStackTrace();
            }
    }

    public void viewPatient()
    {
        String query = "select * from patients";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Patients: ");
            System.out.println("+------------+--------------------+----------+------------+");
            System.out.println("| Patient Id | Name               | Age      | Gender     |");
            System.out.println("+------------+--------------------+----------+------------+");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                System.out.printf("| %-10s | %-18s | %-8s | %-10s |\n", id, name, age, gender);
                System.out.println("+------------+--------------------+----------+------------+");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean getPatientsByid(int id)
    {
        String query = "SELECT * FROM patients WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


}
