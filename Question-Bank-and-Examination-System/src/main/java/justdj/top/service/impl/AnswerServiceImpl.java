/*
  Created by IntelliJ IDEA.
  User: shan
  Date: 18.5.13
  Time: 21:35
*/

package justdj.top.service.impl;

import justdj.top.dao.AnswerMapper;
import justdj.top.pojo.Answer;
import justdj.top.pojo.AnswerQuestion;
import justdj.top.pojo.Kind;
import justdj.top.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service("answerService")
public class AnswerServiceImpl implements AnswerService{
	
	@Autowired
	private AnswerMapper answerMapper;
	
	
	@Override
	public List<Answer> selectAnswerByExamId(BigInteger examId) {
		return answerMapper.selectAnswerByExamId(examId);
	}
	
	@Override
	public List <Answer> selectAnswerByTestPaperId(BigInteger testPaperId) {
		return answerMapper.selectAnswerByTestPaperId(testPaperId);
	}
	
	@Override
	public Answer selectAnswerByAnswerId(BigInteger answerId) {
		return answerMapper.selectAnswerByAnswerId(answerId);
	}
	
	@Override
	public Answer selectAnswerByExamIdAndStudentId(BigInteger examId, BigInteger studentId) {
		return answerMapper.selectAnswerByExamIdAndStudentId(examId,studentId);
	}
	
	@Override
	public List <AnswerQuestion> selectAnswerQuestionByAnswerId(BigInteger answerId) {
		return answerMapper.selectAnswerQuestionByAnswerId(answerId);
	}
	
	@Override
	public List <Kind> selectQuestionKindByAnswerId(BigInteger answerId) {
		return answerMapper.selectQuestionKindByAnswerId(answerId);
	}
}
