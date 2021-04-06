package example04.com.cg.entity;

import org.springframework.stereotype.Service;

@Service
public class SpellChecker {
	public SpellChecker() {
		System.out.println("Running spellchecker");
	}

	public void checkSpell() {
		System.out.println("Checking spellings");
	}
}
