package com.yoonveloping.jpabook.service;

import com.yoonveloping.jpabook.domain.Member;
import com.yoonveloping.jpabook.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	public Long join(Member member) {
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		//TODO::name 보다는 email 중복은 어떨까?
		final List<Member> findMembers = memberRepository.findByName(member.getName());
		if (!findMembers.isEmpty()) {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}
	}

	@Transactional(readOnly = true)
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Member findOne(Long id) {
		return memberRepository.findOne(id);
	}
}
