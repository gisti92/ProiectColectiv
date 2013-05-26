/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.administrator;

/**
 *
 * @author S7eve
 */
public class State {
        private int idCadruDidactic;
        private int idDisciplina;
        private int idSectia;
        private int an;
        private int oreC1;
        private int oreS1;
        private int oreL1;
        private int oreC2;
        private int oreS2;
        private int oreL2;

    public State(int idCadruDidactic, int idDisciplina, int idSectia, int an, int oreC1, int oreS1, int oreL1, int oreC2, int oreS2, int oreL2) {
        this.idCadruDidactic = idCadruDidactic;
        this.idDisciplina = idDisciplina;
        this.idSectia = idSectia;
        this.an = an;
        this.oreC1 = oreC1;
        this.oreS1 = oreS1;
        this.oreL1 = oreL1;
        this.oreC2 = oreC2;
        this.oreS2 = oreS2;
        this.oreL2 = oreL2;
    }

    public int getIdCadruDidactic() {
        return idCadruDidactic;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public int getIdSectia() {
        return idSectia;
    }

    public int getAn() {
        return an;
    }

    public int getOreC1() {
        return oreC1;
    }

    public int getOreS1() {
        return oreS1;
    }

    public int getOreL1() {
        return oreL1;
    }

    public int getOreC2() {
        return oreC2;
    }

    public int getOreS2() {
        return oreS2;
    }

    public int getOreL2() {
        return oreL2;
    }
    
    
}
