package com.back;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class QuestionRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;
//
//    @Test
//    void t1(){
//        Question q1 = new Question();
//        q1.setSubject("Sbb가 무엇");
//        q1.setContent("무엇이낙");
//        questionRepository.save(q1);
//
//        Answer a1 = new Answer();
//        a1.setContent("게시판입니다");
//        a1.setQuestion(q1);
//        answerRepository.save(a1);
//
//        Answer a2 = new Answer();
//        a2.setContent("나도 몰라요");
//        a2.setQuestion(q1);
//        answerRepository.save(a2);
//    }
//    @Test
//    @Transactional
//    void t2(){
//        Question q1 = questionRepository.findById(1).get();
//        System.out.println(q1.getSubject());
//        System.out.println(q1.getContent());
//
//        List<Answer> answers = q1.getAnswerList();
//        for(Answer a : answers){
//            System.out.println(a.getContent());
//        }
//}

    @Test
    void t1() {
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }

    @Test
    void t2(){
        Question q1 = questionRepository.findById(1).get();
        assertEquals("sbb가 무엇인가요?",q1.getSubject());
    }

    @Test
    void t3(){
        Question q1 = questionRepository.findBySubject("sbb가 무엇인가요?").get();

        assertThat(q1.getId()).isEqualTo(1);
        assertThat(q1.getContent()).isEqualTo("sbb에 대해서 알고 싶습니다.");
    }

    @Test
    @DisplayName("질문 수정")
    void t4(){
        Question q1 = questionRepository.findById(1).get();
        q1.setSubject("sbb가 무엇인가요? - 수정");
        questionRepository.flush(); // 변경 내용을 DB에 즉시 반영

        assertThat(q1.getSubject()).isEqualTo("sbb가 무엇인가요? - 수정");
    }

    @Test
    @DisplayName("질문 삭제")
    void t5(){
        Question q1 = questionRepository.findById(1).get();
        questionRepository.delete(q1);
        assertThat(questionRepository.count()).isEqualTo(1);
    }
}
