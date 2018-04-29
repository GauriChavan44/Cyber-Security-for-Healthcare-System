/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Security;

import Business.Person.Person;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Gauri
 */
public class Tier2Analyst extends Person{
   
    private WorkQueue workQueue;
    
    public Tier2Analyst(){
        workQueue = new WorkQueue();
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
}
