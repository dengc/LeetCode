//4. Median of Two Sorted Arrays
//Map: key为array的值，value为array的index 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int l1 = nums1.length;
    	int l2 = nums2.length;
    	int l = l1 + l2;
        int temp[] = new int[l];
    
    	int i=0, j=0, k=0;
	    while(k < l){
	        if(j >= l2 || i < l1 && nums1[i] <= nums2[j]){
	            temp[k++] = nums1[i++];
	        }else{
	            temp[k++] = nums2[j++];
	        }
	    }
	    
	    int mid = l / 2;
	    if(l % 2 != 0){
	        return temp[mid] /1.0;
	    }else{
	        return (temp[mid] + temp[mid-1]) /2.0;
	    }    
    }
}