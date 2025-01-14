package com.db.hack.data.retrieval;

import com.db.hack.beans.Question;
import com.db.hack.databse.DatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roshan on 6/4/2019.
 */
public class QuestionsRetrieval {

    private DatabaseConnectionFactory dataBaseConnectionFactory;

    public QuestionsRetrieval(DatabaseConnectionFactory daataBaseConnectionFactory) {
        this.dataBaseConnectionFactory = daataBaseConnectionFactory;
    }



    public List<Question> getAllQuestions(){
        List<Question> questionsList = new ArrayList<>();
        Connection conn = dataBaseConnectionFactory.getConnection();
        if (conn!=null)
        {

            try
            {
                Statement select = conn.createStatement();
                ResultSet result=select.executeQuery("Select ID,question,option1,option2,option3,option4,topic," +
                        "grade,difficulty_level,correct_answer,Rationale,question_hint from dbo.Questions");
                while (result.next())
                {
                    questionsList.add(new Question(result.getInt("ID"),result.getString("question"),result.getString("option1"),
                            result.getString("option2"),result.getString("option3"),result.getString("option4"),
                            result.getString("correct_answer"),result.getString("topic"), result.getString("grade"),result.getString("difficulty_level"),
                            result.getString("Rationale"),result.getString("question_hint")));
                    /**
                     * create table dbo.Questions
                     ( ID int PRIMARY KEY IDENTITY(1,1),
                     question nvarchar(500),
                     option1 nvarchar(1000),
                     option2 nvarchar(1000),
                     option3 nvarchar(1000),
                     option4 nvarchar(1000),
                     topic nvarchar(100),
                     grade varchar(20),
                     difficulty_level varchar(10),
                     correct_answer nvarchar(1000),
                     Rationale nvarchar(1000),
                     question_hint nvarchar(1000),
                     )
                     */

                }
            }
            catch(Exception e)
            {

            }
        }

        return questionsList;
    }

}
