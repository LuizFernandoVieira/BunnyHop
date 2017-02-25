package com.libgdx.game.enums;

public enum PlayerWeapon {

    GUN(0, "Gun"),
    SHOTGUN(1, "Shotgun"),
    MISSLE_GUN(2, "MissleGun"),
    MACHINE_GUN(3, "MachineGun");

    private int codigo;
    private String descricao;

    PlayerWeapon(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
