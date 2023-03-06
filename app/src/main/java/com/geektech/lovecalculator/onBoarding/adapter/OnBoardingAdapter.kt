import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geektech.lovecalculator.R
import com.geektech.lovecalculator.databinding.ItemOnboardingBinding
import com.geektech.lovecalculator.remote.OnBoard

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val data: ArrayList<OnBoard>
        get() = arrayListOf(
            OnBoard(
                "LoveCalculator",
                "вы можете узнать совместимоть",
                R.drawable.love_calc_2
            ),
            OnBoard(
                "LoveCalculator",
                "введите ваше имя",
                R.drawable.love_calc_2
            ),
            OnBoard(
                "LoveCalculator",
                "введите имя любимого/мой",
                R.drawable.love_calc_2
            ),
            OnBoard(
                "LoveCalculator",
                "нажмите на кнопку",
                R.drawable.love_calc_2
            ),
        )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.tvTitle.text = onBoard.title
            binding.tvDesc.text = onBoard.desc
            binding.image.setImageResource(onBoard.image!!)
            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.btnStart.setOnClickListener {
                onClick()
            }
        }
    }
}