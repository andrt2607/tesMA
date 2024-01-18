// package com.example.tesMA.tesMA.services.impl;

// import java.util.List;
// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;

// import com.example.tesMA.tesMA.models.Category;
// import com.example.tesMA.tesMA.models.Thread;
// import com.example.tesMA.tesMA.repos.CategoryRepo;
// import com.example.tesMA.tesMA.repos.ThreadRepo;
// import com.example.tesMA.tesMA.services.ThreadService;
// import com.example.tesMA.tesMA.utils.Constant;
// import com.example.tesMA.tesMA.utils.DateUtil;
// import com.example.tesMA.tesMA.utils.dto.request.ThreadRequest;
// import com.example.tesMA.tesMA.utils.dto.response.DefaultResponse;

// @Service
// public class ThreadServiceImpl implements ThreadService{

//     @Autowired
//     private ThreadRepo repo;

//     @Override
//     public ResponseEntity<DefaultResponse> getAllThreads() {
//         DefaultResponse defaultResponse = new DefaultResponse();
//         defaultResponse.setMessage(Constant.MSG_DATA_FOUND);
//         defaultResponse.setData(repo.findAll());
//         return ResponseEntity.ok().body(defaultResponse);
//     }

//     @Override
//     public ResponseEntity<DefaultResponse> createThread(ThreadRequest request) {
//         Thread thread2 = new Thread();
//         // thread2.setTitle();
//         // thread2.setContent(thread.());

//         // category.setCreatedAt(DateUtil.getCurrentTimestamp());
//         // category.setUpdatedAt(DateUtil.getCurrentTimestamp());
//         DefaultResponse defaultResponse = new DefaultResponse();
//         defaultResponse.setMessage(Constant.MSG_DATA_CREATED);
//         // defaultResponse.setData(repo.save(category));
//         // repo.save(category);
//         return ResponseEntity.created(null).body(defaultResponse);
//     }

//     @Override
//     public ResponseEntity<DefaultResponse> updateThread(int id, Thread thread) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'updateThread'");
//     }

//     @Override
//     public ResponseEntity<DefaultResponse> deleteThread(int id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteThread'");
//     }

//     @Override
//     public Thread getThreadById(UUID id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getThreadById'");
//     }

    
    
// }
