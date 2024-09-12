package com.ubaya.week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubaya.week1.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    //CUMAN LOAD LAYOUT
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    //SETELAH LAYOUT DI LOAD, ADD BUTTON, TEXT, DLL
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnStart.setOnClickListener {
            //class MainFragmentDirection dibuatkan otomatis android studio
            //karena ada argument di GameFragment, maka harus ada argument/data yang dikirim
            val name = binding.editName.text.toString()
            val action = MainFragmentDirections.actionGameFragment(name)
            //memanggil action, kalau tombol start ditekan akan go to gameFragment
            Navigation.findNavController(it).navigate(action)
        }

        //code untuk memunculkan dialog setting(optionfragment)
        binding.btnOption.setOnClickListener{
            val action = MainFragmentDirections.actionOptionFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

}