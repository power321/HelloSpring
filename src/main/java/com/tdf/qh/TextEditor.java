package com.tdf.qh;

public class TextEditor {
	private SpellChecker spellChecker;
	
	/*
	 * ���Ի��ڹ��캯��������ע�� 
	public TextEditor(SpellChecker spellChecker) {
		System.out.println("Inside TextEditor constructor.");
		this.spellChecker = spellChecker;
	}
	*/
	
	
	public void spellCheck() {
		spellChecker.checkSpelling();
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println("Inside setSpellChecker.");
		this.spellChecker = spellChecker;
	}
}
