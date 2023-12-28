package be.mcabla.cards.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import be.mcabla.cards.R
import be.mcabla.cards.databinding.FragmentDashboardBinding
import be.mcabla.cards.ui.card.CardAdapter
import be.mcabla.cards.ui.card.CardItem

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val recyclerView: RecyclerView = binding.cardsViewDashboard
        val cardList = listOf(
            CardItem("Card 1", "Description 1", R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background),
            CardItem("Card 2", "Description 2", R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background),
            CardItem("Card 3", "Description 3", R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background),
            CardItem("Card 4", "Description 4", R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background),
            // Add more cards as needed
        )

        val cardAdapter = CardAdapter(cardList)
        recyclerView.adapter = cardAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}