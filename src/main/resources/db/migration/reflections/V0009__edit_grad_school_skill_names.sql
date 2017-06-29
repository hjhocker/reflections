delete from skill
  where name in ('Autodock Vina',
    'Visual Molecular Dynamic (VMD)',
    'NAMD - Scalable Molecular Dynamics');

insert into skill (name, years_of_experience, proficiency)
  values
  ('Vina', 3, 'INTERMEDIATE'),
  ('VMD', 5, 'INTERMEDIATE'),
  ('NAMD', 4, 'INTERMEDIATE');
