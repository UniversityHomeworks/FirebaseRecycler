package top.jonakls.firebaserecycler.model.adapt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import top.jonakls.firebaserecycler.R;
import top.jonakls.firebaserecycler.model.PersonModel;

public class CollectPersonAdapter extends RecyclerView.Adapter<CollectPersonAdapter.PersonViewHolder> {

    private final List<PersonModel> personModelList;

    public CollectPersonAdapter(List<PersonModel> personModelList) {
        this.personModelList = personModelList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_person_view, parent, false);

        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        final PersonModel personModel = this.personModelList.get(position);
        holder.name.setText(personModel.getName());
        holder.email.setText(personModel.getEmail());
        holder.phone.setText(String.valueOf(personModel.getPhone()));
    }

    @Override
    public int getItemCount() {
        return this.personModelList.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        final TextView name;
        final TextView email;
        final TextView phone;

        public PersonViewHolder(@NotNull View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.view_name);
            this.email = itemView.findViewById(R.id.view_email);
            this.phone = itemView.findViewById(R.id.view_phone);
        }
    }

}
