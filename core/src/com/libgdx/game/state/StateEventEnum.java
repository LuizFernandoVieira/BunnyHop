package com.libgdx.game.state;

public enum StateEventEnum {
	
	SPLASH_END(1),
	MENU_TO_PLAY(2),
	MENU_TO_OPTIONS(3),
	MENU_TO_EXIT(4),
	OPTIONS_TO_MENU(5);
	
	private int codigo;
	
	private StateEventEnum(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
