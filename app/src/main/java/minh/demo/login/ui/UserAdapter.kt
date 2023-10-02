package minh.demo.login.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import minh.demo.login.data.model.User
import minh.demo.login.databinding.ItemUserBinding
import minh.demo.login.BR

class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.UserHolder>() {

    class UserHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(user: User) {
            binding.setVariable(BR.user, user)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return UserHolder(binding)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val user = users[position]
        holder.bindView(user)
    }
}