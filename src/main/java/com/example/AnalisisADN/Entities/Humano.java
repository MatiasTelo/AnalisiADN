package com.example.AnalisisADN.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Arrays;
import java.util.stream.IntStream;

@Entity
@Table(name = "Humano")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Humano extends Base{
    private String nombre;
    private String apellido;
    private String dna;

    public void setdna(String[] adnStrArray) {
        StringBuilder adnBuilder = new StringBuilder();
        for (String fila : adnStrArray) {
            adnBuilder.append(fila);
        }
        this.dna = adnBuilder.toString();
    }

    public String[] getdna() {
        int n = (int) Math.sqrt(dna.length());
        String[] adnArray = new String[n];
        for (int i = 0; i < n; i++) {
            adnArray[i] = dna.substring(i * n, (i + 1) * n);
        }
        return adnArray;
    }

    public boolean isMutant(){
        int n = this.getdna().length;

        boolean horizontal = Arrays.stream(this.getdna()).anyMatch(row ->
                IntStream.range(0, n - 3).anyMatch(j ->
                        row.charAt(j) == row.charAt(j + 1) &&
                                row.charAt(j) == row.charAt(j + 2) &&
                                row.charAt(j) == row.charAt(j + 3)));

        boolean vertical = IntStream.range(0, n).anyMatch(j ->
                IntStream.range(0, n - 3).anyMatch(i ->
                        this.getdna()[i].charAt(j) == this.getdna()[i + 1].charAt(j) &&
                                this.getdna()[i].charAt(j) == this.getdna()[i + 2].charAt(j) &&
                                this.getdna()[i].charAt(j) == this.getdna()[i + 3].charAt(j)));

        boolean diagonalRight = IntStream.range(0, n - 3).anyMatch(i ->
                IntStream.range(0, n - 3).anyMatch(j ->
                        this.getdna()[i].charAt(j) == this.getdna()[i + 1].charAt(j + 1) &&
                                this.getdna()[i].charAt(j) == this.getdna()[i + 2].charAt(j + 2) &&
                                this.getdna()[i].charAt(j) == this.getdna()[i + 3].charAt(j + 3)));

        boolean diagonalLeft = IntStream.range(3, n).anyMatch(i ->
                IntStream.range(0, n - 3).anyMatch(j ->
                        this.getdna()[i].charAt(j) == this.getdna()[i - 1].charAt(j + 1) &&
                                this.getdna()[i].charAt(j) == this.getdna()[i - 2].charAt(j + 2) &&
                                this.getdna()[i].charAt(j) == this.getdna()[i - 3].charAt(j + 3)));

        return horizontal || vertical || diagonalRight || diagonalLeft;
    }

}
