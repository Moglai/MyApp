package com.example.myapp

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.databinding.FragmentNewTaskBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewTask(var taskModel: TaskModel?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewTaskBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
        if (taskModel != null) {
            binding.NewTask.text = "Change Task"
            val editable = Editable.Factory.getInstance()
            binding.cTitle.text = editable.newEditable(taskModel!!.name)
            binding.cDescription.text = editable.newEditable(taskModel!!.desc)
        }
        else {
            binding.NewTask.text = "New Task"
        }

        taskViewModel = ViewModelProvider(activity).get(TaskViewModel::class.java)
        binding.okButt.setOnClickListener {
            saveAll()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun saveAll() {
        val name = binding.cTitle.text.toString()
        val desc = binding.cDescription.text.toString()
        if (taskModel == null) {
            val newTask = TaskModel(name, desc)
            taskViewModel.addTaskModel(newTask)
        }
        else {
            taskViewModel.updateTaskModel(taskModel!!.id, name, desc)
        }
        binding.cTitle.setText("")
        binding.cDescription.setText("")
        dismiss()
    }
}