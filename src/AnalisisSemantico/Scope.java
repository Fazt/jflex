/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisSemantico;

import java.util.List;

/**
 *
 * @author Spartan
 */
class Scope {
    
    int scopeNumber;
    List<Declaration> decl;
    
    void Scope(){
        this.scopeNumber=0;
    }
    Scope createScope(Declaration dl){
        
        this.scopeNumber ++;
        decl.add(dl);
        
        return this;
    }
    void insert_alcance(){}
}
