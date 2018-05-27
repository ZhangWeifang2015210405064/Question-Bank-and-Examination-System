/*
  Created by IntelliJ IDEA.
  User: shan
  Date: 18.5.13
  Time: 21:32
*/

package justdj.top.service;

import justdj.top.pojo.Answer;
import justdj.top.pojo.AnswerQuestion;
import justdj.top.pojo.Kind;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface AnswerService {
	
	List<Answer> selectAnswerByExamId(BigInteger examId);
	
	List<Answer> selectAnswerByTestPaperId(BigInteger testPaperId);
	
	Answer selectAnswerByAnswerId(BigInteger answerId);
	
	Answer selectAnswerByExamIdAndStudentId(BigInteger examId,BigInteger studentId);
	
	List<AnswerQuestion> selectAnswerQuestionByAnswerId(BigInteger answerId);
	
	List<Kind> selectQuestionKindByAnswerId(BigInteger answerId);
}
