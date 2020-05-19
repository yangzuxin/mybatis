package com.test.demo;

public class TestDemo01 {
/**
 * 朋友修改，没测试
 * */
//	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		// 给定一个数组arr {1,2,3,9,6,7,9,4,5},根据最大值,拆分成 { {1,2,3} {6,7,} {4,5} }
//		/*
//		 * 思路: 1.找出数组arr中元素的最大值和最大值的索引 2.根据相同最大值的个数确定拆分数组的个数
//		 * 3.根据最大值的索引将数组arr划分成几个部分 4.新数组的元素对应每个部分中的元素 5.定义二维数组,长度为相同最大值的个数
//		 * 6.二维数组中的一维数组元素分别对应每个部分中的元素 7.定义变量记录最大值,最大值的索引,相同最大值的个数
//		 * 8.遍历数组arr,跳过元素中的最大值,根据划分部分将元素分别存放在新的数组中
//		 */
//
//		int[] arr = { 1, 2, 3, 9, 6, 7, 9, 4, 5 }; // 原数组
//
//		int count = 0; // 定义一个变量记录最大值的个数(计数器)
//		int max = 0; // 定义一个变量记录最终最大值
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] > max) {
//				max = arr[i]; // 记录当前最大值
//			} else if (arr[i] <= max) {
//				if (arr[i] == max) {
//					count++; // 记录当前相同最大值个数
//				}
//			}
//		}
//		System.out.println("最大值为: " + max); // 9
//		System.out.println("相同最大值的个数为:  " + count); // 2
//
//		int max2 = arr[0]; // 记录最大值
//		int index = 0; // 记录第一个最终最大值的索引
//		int index2 = 0; // 记录第二个相同最大值的索引
//		for (int i = 0; i < arr.length; i++) { // 遍历数组arr,找出元素中两个最大值的索引
//			System.out.println(arr[i]);
//			if (arr[i] > max2) {
//				index++; // 同步记录最大值的索引
//				index2++;
//			} else if (arr[i] <= max2) {
//				if (arr[i] == max2) {
//					index2++; // 同步记录第二个相同最大值的索引
//				}
//			}
//		}
//		index2++;
//		System.out.println(max);
//		System.out.println(index);
//		System.out.println(index2);
//		System.out.println("--------------------");
//
//		int[][] arr2 = new int[count][];
//		System.out.println(count);
//		System.out.println(arr2[0][0]);
//		for (int i = 0; i < arr2.length; i++) {
//			for (int j = 0; j < arr2[i].length; j++) {
//				arr2[i][j] = arr[i];
//				System.out.println(arr2[i][j]);
//			}
//		}
//	}
}
