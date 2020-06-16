import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException; 


public class CatTree implements Iterable<CatInfo>{
    public CatNode root;
    
    public CatTree(CatInfo c) {
        this.root = new CatNode(c);
    }
    
    private CatTree(CatNode c) {
        this.root = c;
    }
    
    
    public void addCat(CatInfo c)
    {
        this.root = root.addCat(new CatNode(c));
    }
    
    public void removeCat(CatInfo c)
    {
        this.root = root.removeCat(c);
    }
    
    public int mostSenior()
    {
        return root.mostSenior();
    }
    
    public int fluffiest() {
        return root.fluffiest();
    }
    
    public CatInfo fluffiestFromMonth(int month) {
        return root.fluffiestFromMonth(month);
    }
    
    public int hiredFromMonths(int monthMin, int monthMax) {
        return root.hiredFromMonths(monthMin, monthMax);
    }
    
    public int[] costPlanning(int nbMonths) {
        return root.costPlanning(nbMonths);
    }
    
    
    
    public Iterator<CatInfo> iterator()
    {
        return new CatTreeIterator();
    }
    
    
    class CatNode {
        
        CatInfo data;
        CatNode senior;
        CatNode same;
        CatNode junior;
        
        public CatNode(CatInfo data) {
            this.data = data;
            this.senior = null;
            this.same = null;
            this.junior = null;
        }
        
        public String toString() {
            String result = this.data.toString() + "\n";
            if (this.senior != null) {
                result += "more senior " + this.data.toString() + " :\n";
                result += this.senior.toString();
            }
            if (this.same != null) {
                result += "same seniority " + this.data.toString() + " :\n";
                result += this.same.toString();
            }
            if (this.junior != null) {
                result += "more junior " + this.data.toString() + " :\n";
                result += this.junior.toString();
            }
            return result;
        }
        
        
		public CatNode addCat(CatNode cN) {
            if(cN==null) {
            
            	return this;
            }else
            {   
            	    
            	    if (this.data.monthHired==cN.data.monthHired) {
            	    	if(cN.data.furThickness>this.data.furThickness) {
            	    		cN.same=this;
            	    		cN.junior=this.junior;
            	    		cN.senior=this.senior;
            	    		this.junior=null;
            	    		this.senior=null;
            	    		return cN;
            	    	}else if (this.same==null){
            	    		this.same=cN;
            	    		return this;
            	    	}else {
            	    	     if (cN.data.furThickness<this.same.data.furThickness) {
            	    		    if(this.same.same==null) {
            	    			    this.same.same=cN;
            	    			    return this;
            	    		    }
            	    		
            	    		    this.same.addCat(cN);
            	    	    }else if(cN.data.furThickness>this.same.data.furThickness&&cN.data.furThickness<this.data.furThickness) {
            	    		    cN.same=this.same;
            	    		    cN.junior=this.same.junior;
            	    		    cN.senior=this.same.senior;
            	    		    cN.same.junior=null;
            	    		    cN.same.senior=null;
            	    		    this.same=cN;
            	    		    return this;
            	    	   }
            	       }
            	    }
            	    
            	  else if (this.data.monthHired>cN.data.monthHired) {
            		  if(this.senior==null) {
            			  this.senior=cN;
            			  return this;
            		  }else {
            			  this.senior.addCat(cN);
            			  return this;
            		  }
            	  }
            	  
            	  
            	  else if (this.data.monthHired<cN.data.monthHired) {
            		  if(this.junior==null) {
            			  this.junior=cN;
            			  return this;
            		  }else {
            			  this.junior.addCat(cN);
            			  return this;
            		  }
            	 }
            	return this;    
            }
			
			
		 }
        
        
    	public CatNode removeCat(CatInfo cinf) {
   		 CatNode rtc =this;
   		 if(rtc.data.equals(cinf)) {
   			 
   			 if(rtc.same!=null) {
   				 CatNode tempc = rtc;
   				 rtc.data=rtc.same.data;
   				 rtc.same=tempc.same.same;
   				 tempc=null;//clear for next recur
   			 } else if (rtc.senior!=null) {
   				 CatNode rtsj =rtc.senior.junior;
   				 CatNode rts  =rtc.senior;
   				 CatNode rtj  =rtc.junior;
   				 
   				 rtc.data=rtc.senior.data;
   				 rtc.senior=rts.senior;
   				 rtc.same=rts.same;
   				 if(rtsj!=null) {
   					 rtc.junior=rtsj;
   					 rtc.junior.junior=rtj;
   				 }else {
   					 //when rtsj==null do nothing	 
   				 }  				 
   			 } else if (rtc.junior!=null) {
   				 rtc=rtc.junior;
   			 }
   			 
   		 }else {
   				if (cinf.monthHired == rtc.data.monthHired)
           			rtc.same.removeCat(cinf);
           		else if(cinf.monthHired < rtc.data.monthHired && root.senior != null)
           			rtc.senior.removeCat(cinf);
           		else if(cinf.monthHired > rtc.data.monthHired && root.junior != null)
           		    rtc.junior.removeCat(cinf);
   		 }
   		 return rtc;
			   
       }
        
        
    	public int mostSenior() {
    		if(this.senior==null) {
        		return this.data.monthHired;
        	}else {
        		this.senior.mostSenior();
        	}
        	return 0;
		}
        
        
        public int fluffiest() {
            int maxflu = 0;
            CatNode Root = this;
            if (Root.data.furThickness > maxflu)
            	maxflu = Root.data.furThickness;
            if (Root.senior != null) {
            	if (Root.senior.fluffiest() > maxflu)
            		maxflu = Root.senior.fluffiest();
            }
            if (Root.junior != null) {
            	if (Root.junior.fluffiest() > maxflu)
            		maxflu = Root.junior.fluffiest();
            }
            if (Root.same != null) {
            	if (Root.same.fluffiest() > maxflu)
            		maxflu = Root.same.fluffiest();
            }
            return maxflu; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
        }
        
        
        public int hiredFromMonths(int monthMin, int monthMax) {
            
        	int round =0;
    		if(monthMin>monthMax)
				return 0;
			else {
				if(this.data.monthHired>=monthMin&&this.data.monthHired<=monthMax)
					round += 1;
			    if(this.senior!=null)
					round += this.senior.hiredFromMonths(monthMin, monthMax);
			    if(this.same!=null)
					round += this.same.hiredFromMonths(monthMin, monthMax);
				if(this.junior!=null)
					round += this.junior.hiredFromMonths(monthMin, monthMax);
				return round;
			}
            
        }
        
    	public CatInfo fluffiestFromMonth(int month) {
			if(this.data.monthHired==month) {
				return this.data;
			}
			else if(this.senior != null && this.data.monthHired >month ) {
				return this.senior.fluffiestFromMonth(month);
			}
			else if(this.junior != null && this.data.monthHired <month) {
				return this.junior.fluffiestFromMonth(month);
			}
			else 
				return null;
			
		}
        
    	
        public int[] costPlanning(int nbMonths) {
        	
        	CatTreeIterator iterator = new CatTreeIterator();
        	int[] cost = new int[nbMonths];
        	
        	for(int i=0; i<nbMonths; i++) {
        		for (CatNode Node: iterator.ct_nodes) {
        			if (Node.data.nextGroomingAppointment == i+243)
        				cost[i] += Node.data.expectedGroomingCost;
        		}
        	}
        	
            return cost; 
        } 
    }
    
    private class CatTreeIterator implements Iterator<CatInfo> {
    	
        ArrayList<CatNode> ct_nodes = new ArrayList<CatNode>();
        private int cur = 0;
        private int size = 0;
        
          public CatTreeIterator() {
        	this.visit(root);
        	current = ct_nodes.get(0);
        	size = ct_nodes.size();
        }
          
        private void visit(CatNode root) {
        	if (root.senior != null)
        		visit(root.senior);
        	if (root.same != null)
        		visit(root.same);
        	ct_nodes.add(root);
        	if (root.junior != null)
        		visit(root.junior);
        }
        
      
        
        public CatInfo next(){
           
        	CatNode c = ct_nodes.get(cur);
        	current =  ct_nodes.get(cur+1);
        	cur++;
            return c.data; 
        }
        
        public boolean hasNext() {
            return (cur<size); 
        }
        
    }  
        private CatNode current;
     
    
}

