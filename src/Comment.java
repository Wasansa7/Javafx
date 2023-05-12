/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectallmyscens;

/**
 *
 * @author Wasan
 */
public class Comment {

    int rate;
    String text;

    public Comment(int rate, String text) {

        this.rate = rate;
        this.text = text;
    }

    public Comment() {
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text + "\t" + this.rate;
    }
}
