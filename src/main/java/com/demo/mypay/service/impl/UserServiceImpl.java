package com.demo.mypay.service.impl;

import com.demo.mypay.api.dto.ResponseDto;
import com.demo.mypay.api.dto.UserAuthDto;
import com.demo.mypay.api.dto.UserDto;
import com.demo.mypay.businessService.UserAuthBusinessService;
import com.demo.mypay.businessService.UserBusinessService;
import com.demo.mypay.businessService.converter.UserConverter;
import com.demo.mypay.domain.User;
import com.demo.mypay.domain.UserAuthentication;
import com.demo.mypay.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserBusinessService userBusinessService;
    private final UserAuthBusinessService userAuthBusinessService;
    private final UserConverter userConverter;


    @Override
    public ResponseDto create(UserAuthDto userAuthDto) {
        User userExists = userBusinessService.getByPhoneNo(userAuthDto.getUserDto().getPhoneNo());
        if (userExists != null) {
            throw new RuntimeException("User Already Created for " + userAuthDto.getUserDto().getPhoneNo());
        }
        User user = userBusinessService.create(userConverter.convert(userAuthDto.getUserDto()));
        UserAuthentication userAuthentication = new UserAuthentication();
        userAuthentication.setPassword(userAuthDto.getPassword());
        userAuthentication.setUser(user);
        userAuthBusinessService.create(userAuthentication);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("User Created");
        return responseDto;
    }

    @Override
    public ResponseDto get(String id) {
        UserDto userDto = userConverter.convert(userBusinessService.get(id));
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(userDto);
        return responseDto;
    }

    @Override
    public ResponseDto update(UserAuthDto userAuthDto) {
        User userExists = userBusinessService.get(userAuthDto.getUserDto().getId());
        if (userExists != null) {
            throw new RuntimeException("User Not Found " + userAuthDto.getUserDto().getPhoneNo());
        }
        userExists.setFirstName(userAuthDto.getUserDto().getFirstName());
        userExists.setLastName(userAuthDto.getUserDto().getLastName());
        userExists.setDob(userAuthDto.getUserDto().getDob());
        // TODO: 4/29/2023 update password 
        userBusinessService.create(userExists);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("User Updated");
        return responseDto;
    }

    @Override
    public ResponseDto filter(String phoneNo, LocalDate date) {
        ResponseDto responseDto = new ResponseDto();
        List<User> userList = userBusinessService.findAll();
        //brute force
//        for(User u:userList){
//            if(u.getPhoneNo().equalsIgnoreCase(phoneNo)){
//                responseDto.setData(u);
//            }
//        }
        //divide and conquer
//        responseDto.setData(findByPhone(userList, phoneNo, 0, userList.size() - 1));

        int arr[] = {5, 2, 3, 4,9,6};
        int exarr[] = new int[arr.length+1];
        for(int i = 0;i < exarr.length;i++){
            if(i < (arr.length)/2){
                exarr[i]  =arr[i];
            }
            else if (i == (arr.length)/2){
                exarr[i] = 0;
            }
            else if(i > (arr.length)/2){
                exarr[i]  =arr[i-1];
            }
        }
        log.info("exarr "+ Arrays.toString(Arrays.stream(exarr).toArray()));
        return responseDto;
    }

    private User findByPhone(List<User> userList, String phoneNo, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        if (userList.get(mid).getPhoneNo().equalsIgnoreCase(phoneNo)) {
            return userList.get(mid);
        }

        // Search left half
        User leftUser = findByPhone(userList, phoneNo, left, mid - 1);
        if (leftUser != null) {
            return leftUser;
        }

        // Search right half
        User rightUser = findByPhone(userList, phoneNo, mid + 1, right);
        if (rightUser != null) {
            return rightUser;
        }
        return null;
    }

    private User userHasPhone(User user, String phoneNo) {
        User returnUser = null;
        if (user.getPhoneNo().equalsIgnoreCase(phoneNo)) {
            returnUser = user;
        }
        return returnUser;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}
